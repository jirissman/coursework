import os

def get_dataset_lines(filename):
    path_to_download_folder = os.path.join(os.path.expanduser('~'), 'Downloads', filename)
    with open(path_to_download_folder) as f:
        return f.read().strip().split('\n')
