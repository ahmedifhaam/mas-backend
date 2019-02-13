
from __future__ import absolute_import, division, print_function

import pathlib
import sys
import pandas as pd
import seaborn as sns

import tensorflow as tf
from tensorflow import keras
from tensorflow.keras import layers

import methods
import numpy as np

import json

#print(tf.__version__)

if len(sys.argv) !=3 : 
	print(" Error : Invalid arguments")
	exit(0)

#print (str(sys.argv))

dataset_path = sys.argv[1]
prediction_val = sys.argv[2]

prediction_val = prediction_val.split(',')

prediction_val = np.array(prediction_val)

output = {}

prediction_val = pd.to_numeric(prediction_val)
output['data'] = prediction_val.tolist()
#print( prediction_val)

column_names = ['cyl_temp','st1','st2','st3','st4','st5','st6','st7','st8','st_avg','oil_t','env_t','humidy','yl1','yl2','yl3','yl4','yl5','yl6','yl7','yl8','yl_avg','rl','rw','out_l','out_w']

pred_col_vals = ['cyl_temp','st1','st2','st3','st4','st5','st6','st7','st8','st_avg','oil_t','env_t','humidy','yl1','yl2','yl3','yl4','yl5','yl6','yl7','yl8','yl_avg','rl','rw']

prediction_val = pd.DataFrame([prediction_val],columns=pred_col_vals)


prediction_val.pop('rl')
prediction_val.pop('rw')
 
#computing outputl
raw_dataset = pd.read_csv(dataset_path, names=column_names,
                      na_values = "0", comment='\t',
                      sep=",", skipinitialspace=True)

dataset = raw_dataset.copy()

dataset.dropna()

dataset.pop('rl')
dataset.pop('rw')
outw = dataset.pop('out_w')

#length
train_dataset = dataset.sample(frac=0.8,random_state=0)
test_dataset = dataset.drop(train_dataset.index)

train_stats = train_dataset.describe()
train_stats.pop("out_l")
train_stats = train_stats.transpose()

train_labels = train_dataset.pop('out_l')
test_labels = test_dataset.pop('out_l')

normed_train_data = methods.norm(train_dataset,train_stats)
normed_test_data = methods.norm(test_dataset,train_stats)

model = methods.build_model(train_dataset)

#only for debugging have to be commented
#example_batch = normed_train_data[:10]
#example_result = model.predict(example_batch)
#print(example_result)
#-----------------------------------------------

EPOCHS = 1000

early_stop = keras.callbacks.EarlyStopping(monitor='val_loss', patience=10)

history = model.fit(normed_train_data, train_labels, epochs=EPOCHS,
                    validation_split = 0.1, verbose=0, callbacks=[early_stop])

loss, mae, mse = model.evaluate(normed_test_data, test_labels, verbose=0)

#print("Testing set Mean Abs Error: {:5.2f} MPG".format(mae))

test_predictions = model.predict(normed_test_data).flatten()

error = test_predictions - test_labels
#print(error)
#print(test_predictions)

#print("--------------------------------------------------")
#print(test_dataset)
#print(prediction_val)
predicted_length = model.predict(methods.norm(prediction_val,train_stats)).flatten()

 

orl = {}
orl['predicted_val'] = predicted_length.tolist()[0]
orl['mae'] = mae

output['length']=orl


#width
dataset.pop('out_l')
dataset['out_w'] = outw
train_dataset = dataset.sample(frac=0.8,random_state=0)
test_dataset = dataset.drop(train_dataset.index)

train_stats = train_dataset.describe()
train_stats.pop("out_w")
train_stats = train_stats.transpose()

train_labels = train_dataset.pop('out_w')
test_labels = test_dataset.pop('out_w')

normed_train_data = methods.norm(train_dataset,train_stats)
normed_test_data = methods.norm(test_dataset,train_stats)

model = methods.build_model(train_dataset)

#only for debugging have to be commented
#example_batch = normed_train_data[:10]
#example_result = model.predict(example_batch)
#print(example_result)
#-----------------------------------------------

EPOCHS = 1000

early_stop = keras.callbacks.EarlyStopping(monitor='val_loss', patience=10)

history = model.fit(normed_train_data, train_labels, epochs=EPOCHS,
                    validation_split = 0.1, verbose=0, callbacks=[early_stop])

loss, mae, mse = model.evaluate(normed_test_data, test_labels, verbose=0)

#print("Testing set Mean Abs Error: {:5.2f} MPG".format(mae))

test_predictions = model.predict(normed_test_data).flatten()
error = test_predictions - test_labels
#print(error)
#print(test_predictions)

predicted_width = model.predict(methods.norm(prediction_val,train_stats)).flatten()

#print(predicted_width)
orw = {}

orw['predicted_val'] = predicted_width.tolist()[0]
orw['mae'] = mae

output['width']=orw

print(json.dumps(output))
