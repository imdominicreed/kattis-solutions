try:
    while True:
        line = input()
        print("%.2f" % (eval(line)))
except EOFError:
    pass