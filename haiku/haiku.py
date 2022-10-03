class TrieNode:
    def __init__(self, value):
        self.children = {}
        self.terminal = False


class Trie:
    def __init__(self):
        self.root = TrieNode('\0')

    def insert(self, string):
        root = self.root
        for s in string:
            if s not in root.children:
                root.children[s] = TrieNode(s)
            root = root.children[s]
        root.terminal = True

    def search(self, string, number_of_syll, index):
        curr = self.root
        if number_of_syll < 0:
            return False
        if index == len(string) and number_of_syll == 0:
            return True
        if index < len(string) and string[index] == ' ':
            index += 1
        for i in range(index, len(string)):
            c = string[i]
            if c not in curr.children:
                return False
            curr = curr.children[c]
            if curr.terminal:
                bool = self.search(string, number_of_syll - 1, i + 1)
                if bool:
                    return bool
        return False


def main():

    number = int(input())
    trie = Trie()

    vowels = []
    for _ in range(number):
        vowels.append(str(input()))
    strings = []

    for _ in range(3):
        strings.append(str(input()))
    for v in vowels:
        trie.insert(v)

    hello = trie.search(strings[0], 5, 0)
    omg = trie.search(strings[1], 7, 0)
    what = trie.search(strings[2], 5, 0)
    return "haiku" if (hello and omg and what) else "come back next year"


print(main())
