"""
Adding polynomials by text matching - Joseph Rissman
Time complexity is O(mn) where m is the size of the first polynomial and n is the size of the second polynomial.
This is due to the nested for loop in the add_polynomails funciton. The outer loop executes at most m times, and the inner loop executes at most m*n times.
Regex searching is O(m*l+n*l) where l is the size of the pattern to match.
However because the size of l is known to always be the same, it is a constant so the regex search becomes O(m+n).
Therefore the total time complexity is O(mn) + O(m+n) = O(mn+m+n) = O(mn).
All other helper functions loop through input polynomials or resulting polynomial at most once.
Since the size of the resulting polynomial is at most m+n, all other functions are O(m), O(n), or O(m+n).
Using the same logic of big-O arithmetic, when the complexity of other functions are added to O(mn), the resulting complexity is still O(mn).
This means the total time complexity of the algorithm is O(mn).

Due to the constraints of the problem, where it's stated that the coefficient and exponent are one-digit integers, the size of the polynomials is bounded to 10.
The exponents can have the values 0-9 so the polynomials can be at most 10 terms long.
This means that the time complexity of the algorithm can be computed by substituting m and n for 10 (the worst case).
Therefore, given the constraints of the problem, the time complexity is technically O(1). I don't think this is the intended answer though.
"""
# import regular expressions
import re

test_case_1 = "(x**3+5x**2-3x+3)+(4x**5-2x**2+1)"
test_case_2 = "(9x**4+2x**3+x**2+7x+2)-(6x**8-x**4+5x**2+7)" # subtraction
test_case_3 = "(3x**8-6x**5+8x**2)+(3x**7+6x**5-5x**2)" # x**5 term is removed

def poly_add_by_string(polynomial_string):
    # break apart initial string into components with regex
    decomposition = re.split('\(|\)',polynomial_string)
    # regex adds empty strings to beginning and end of list so indexing starts at 1
    result_polynomial = add_polynomials(decomposition[1],decomposition[3],decomposition[2])
    return stringify_polynomial(result_polynomial)

def polynomial_string_to_list(polynomial_string):
    # Find all polynomial terms and break into {coefficient}{x**}{power} using regex groups
    terms = re.findall(r'([+-]?[0-9]?)(x?\*?\*?)(\d?)', polynomial_string)
    terms.pop() #remove extra 'empty' term due to regex
    for i, term in enumerate(terms):
        # add in missing 1 coefficients
        if term[0] == '+' or term[0] == '':
            terms[i] = ('1',term[1],term[2])
        elif term[0] == '-':
            terms[i] = ('-1',term[1],term[2])
    return terms

def add_polynomials(left_polynomial_string, right_polynomial_string, operation):
    # break apart polynomial into component terms using helper function
    left_polynomial = polynomial_string_to_list(left_polynomial_string)
    right_polynomial = polynomial_string_to_list(right_polynomial_string)
    result_polynomial = []
    # loop through terms in each polynomial to see if they need to be added/subtracted
    for left_term in left_polynomial:
        # create new term to add to result
        new_term = left_term
        for right_term in right_polynomial:
            # check if the powers are the same
            if left_term[1] == right_term[1] and left_term[2] == right_term[2]:
                # add/subtract coefficients
                if operation == "+":
                    new_coefficient = int(left_term[0])+int(right_term[0])
                else:
                    new_coefficient = int(left_term[0])-int(right_term[0])
                # add new term to result
                new_term = (new_coefficient,left_term[1],left_term[2])
                # remove term from polynomial to not repeat processing later
                right_polynomial.remove(right_term)
                break
        # reached the end of right list, add new term to result
        result_polynomial.append(new_term)
    # completed left polynomial, only terms remaining in right polynomial have nothing to add/subtract
    for term in right_polynomial:
        if operation == "-":
            term = (int(term[0]) * -1,term[1],term[2])
        result_polynomial.append(term)
           
    # sort result polynomial terms by decreasing exponents
    return sorted(result_polynomial, key=lambda x: x[2], reverse=True)

def stringify_polynomial(polynomial_list):
    polynomial_string = ""
    for i, term in enumerate(polynomial_list):
        # if coefficient is 0, do not add
        if int(term[0]) == 0:
            continue
        # handle special cases where coefficient is +1 or -1
        if int(term[0]) == 1:
            if i == 0: #special case of +1 as first term
                polynomial_string += term[1] + term[2]
                continue
            polynomial_string += '+' + term[1] + term[2]
            continue
        if int(term[0]) == -1:
            polynomial_string += '-' + term[1] + term[2]
            continue
        # non-leading term coefficients greater than 1 need + appended
        if int(term[0]) > 1 and i != 0:
            polynomial_string += '+' + str(int(term[0])) + term[1] + term[2]
            continue
        # all other terms can be printed as is
        polynomial_string += str(int(term[0])) + term[1] + term[2]
    return polynomial_string

print(poly_add_by_string(test_case_1))
print(poly_add_by_string(test_case_2))
print(poly_add_by_string(test_case_3))