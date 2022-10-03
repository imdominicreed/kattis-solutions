
#include <iostream>
#include <vector>

using namespace std;

bool checkSurroundings(int i, int j, vector<vector<bool>> grid) {
    vector<vector<int>> moves{{-2, 1},
                              {-2, -1},
                              {2,  -1},
                              {2,  1},
                              {1,  -2},
                              {1,  2},
                              {-1, -2},
                              {-1, 2}};
    for (vector<int> move: moves) {
        int x = i + move[0];
        int y = j + move[1];
        if (x >= 5 || x < 0 || y >= 5 || y < 0) {
            continue;
        }
        if (grid[x][y]) {
            return true;
        }
    }
    return false;
}

int main() {
    vector<vector<bool>> grid(5, vector<bool>(5));
    string line;
    int num = 0;
    for (int i = 0; i < 5; i++) {
        cin >> line;
        for (int j = 0; j < 5; j++) {
            if (line[j] == 'k') {
                grid[i][j] = true;
                num++;
            }
        }
    }
    if (num != 9) {
        cout << "invalid";
        return 0;
    }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (grid[i][j]) {
                    bool test = checkSurroundings(i, j, grid);
                    if (test) {
                        cout << "invalid";
                        return 0;
                    }
                }
            }
        }
    cout << "valid";
    return 0;
}