import random

def get_l(cnt):
    return [random.choice(['off','on']) for i in range(cnt)]

def Toggle_l(cnt):
    while True:
        try:
            x=int(input('Toggle light number: (Enter 0 to exit)? '))
            if 0<=x and x<=cnt:
              return x
            else:
              print('Index is out of range')
        except:
          print('Invalid number')

def get_num_of_l():
    while True:
        try:
            cnt=int(input('Enter number of lights: '))
            return cnt
        except:
          print('Invalid number')

def toggleLights(x,l):
    if l[x - 1] == 'off': l[x - 1] = 'on'
    else:l[x - 1] = 'off'

    if x ==1:
        if l[1] == 'off': l[1] = 'on'
        else: l[1] = 'off'
    elif x==len(l):
        if l[x-2] == 'off': l[x-2] = 'on'
        else: l[x-2] = 'off'
    else:
        if l[x-2]=='off':l[x-2]='on'
        else:l[x-2]='off'
        if l[x]=='off':l[x]='on'
        else:l[x]='off'

#You only win when all lights are off.
def main():
    c = get_num_of_l()
    l = get_l(c)
    while True:
        print('Lights: {}'.format(' '.join(l)))
        if 'on' not in l: 
            print('You win!')
            break
        index = Toggle_l(c) 
        if index==0: 
            if 'on' in l:
                print('Sorry, try again(no win).')
                break
        else:
            toggleLights(index,l)

main()
