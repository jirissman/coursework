import random

def generate_random_string(length):
    return ''.join(random.choice('ab') for _ in range(length))

def has_even_as_and_bs(s):
    return s.count('a') % 2 == 0 and s.count('b') % 2 == 0

even_strings = []
while len(even_strings) < 20:
    s = generate_random_string(random.randint(2, 20))
    if has_even_as_and_bs(s):
        even_strings.append(s)

print("20 random strings with an even number of 'a's and 'b's:")
for s in even_strings:
    print(s)