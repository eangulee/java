print "hello today"
print "life is short,i use python!"

import sys

def func(a,b):
    return (a+b)

if __name__ == '__main__':
    a = []
    for i in range(1, len(sys.argv)):
        a.append((int(sys.argv[i])))

    print(func(a[0],a[1]))