def algorithm1(base: int, exponent: int):
    if exponent == 0:
        return 1
    return base * algorithm1(base, exponent - 1)

def algorithm2(base: int, exponent: int):
    if exponent == 1:
        return base
    return algorithm2(base, exponent / 2) ** 2
        
print("Algorithm 1 Test Cases")
print("4**64="+str(algorithm1(4,64)))
print("6**8="+str(algorithm1(6,8)))
print("2**256="+str(algorithm1(2,256)))
print("5**8="+str(algorithm1(5,8)))
print("Algorithm 2 Test Cases")
print("4**64="+str(algorithm2(4,64)))
print("6**8="+str(algorithm2(6,8)))
print("2**256="+str(algorithm2(2,256)))
print("5**8="+str(algorithm2(5,8)))