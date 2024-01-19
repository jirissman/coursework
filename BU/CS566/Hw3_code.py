import string
import os
import random


def merge(left_filepath,right_filepath,source_filepath):
    with open(left_filepath,'r') as left, open(right_filepath,'r') as right, open(source_filepath,'w') as sorted:
        left_value = left.readline()
        right_value = right.readline()
        # as long as there are still values in either subfile
        while left_value!='' or right_value!='':
            # if the left subfile is exhausted, write right subfile to sorted file
            if left_value == '':
                sorted.write(right_value)
                right_value = right.readline()
                continue
            # if the right subfile is exhasuted, write left subfile to sorted file
            if right_value == '':
                sorted.write(left_value)
                left_value = left.readline()
                continue
            # if the left subfile contains the smaller number, add it to the sorted file
            if int(left_value)<int(right_value):
                sorted.write(left_value)
                left_value = left.readline()
            else: # otherwise add the value from the right subfile to the sorted file
                sorted.write(right_value)
                right_value = right.readline()
    # clean up exhausted subfiles
    os.remove(left_filepath)
    os.remove(right_filepath)
    return source_filepath

def external_sort(source_filepath):
    with open(source_filepath,'r') as source_file:
        unsorted_list = source_file.readlines()
    list_size = len(unsorted_list)

    # Base case: a file of size 0 or 1 is sorted by defintion
    if list_size <= 1:
        return source_filepath

    # Recursive case: divide the file into two smaller files to sort
    left_filepath = source_filepath.split(".txt")[0]+"l"+".txt" # append 'l' to left subfile
    right_filepath = source_filepath.split(".txt")[0]+"r"+".txt" # append 'r' to right subfile
    with open(left_filepath,"x") as subfile_left, open(right_filepath,"x") as subfile_right:
        for i, line in enumerate(unsorted_list):
            if i<(list_size/2):
                subfile_left.write(line)
            else:
                subfile_right.write(line)
    
    # Recursively sort both subfiles
    external_sort(left_filepath)
    external_sort(right_filepath)

    # Merge the subfiles
    return merge(left_filepath,right_filepath,source_filepath)

# set filepath of unsorted files and files to be sorted
small_unsorted_filepath = "C:/Users/joseph.rissman/Desktop/small_unsorted_list.txt"
large_unsorted_filepath = "C:/Users/joseph.rissman/Desktop/large_unsorted_list.txt"
small_sorted_filepath = "C:/Users/joseph.rissman/Desktop/small_sorted_list.txt"
large_sorted_filepath = "C:/Users/joseph.rissman/Desktop/large_sorted_list.txt"
# fill unsorted files with random data
with open(small_unsorted_filepath,'w') as small_file, open(large_unsorted_filepath,'w') as large_file:
    for _ in range(50):
        small_file.write(str(random.randint(0,1000))+'\n')
    for _ in range(10000):
        large_file.write(str(random.randint(0,1000000))+'\n')
# copy data from unsorted to 'sorted' file to preserve record
with open(small_unsorted_filepath,'r') as copy_from, open(small_sorted_filepath,'w') as copy_to:
    for line in copy_from:
        copy_to.write(line)
with open(large_unsorted_filepath,'r') as copy_from, open(large_sorted_filepath,'w') as copy_to:
    for line in copy_from:
        copy_to.write(line)
# sort the files to be sorted
external_sort(small_sorted_filepath)
external_sort(large_sorted_filepath)