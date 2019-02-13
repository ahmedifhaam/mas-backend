from __future__ import absolute_import,division,print_function

import pathlib
import pandas as pd
import seaborn as sns

import tensorflow as tf
from tensorflow import keras
from tensorflow.keras import layers

print(tf.__version__)

column_names = ['MPG','Cylinders','Displacement','Horsepower','Weight','Acceleration', 'Model Year', 'Origin']
raw_dataset = pd.read_csv("auto-mpg.data",names=column_names,na_values = "?" , comment = '\t', sep = " ", skipinitialspace=True)
dataset = raw_dataset.copy()
dataset.tail()
