from __future__ import absolute_import, division, print_function

import pathlib

import pandas as pd
import seaborn as sns

import tensorflow as tf
from tensorflow import keras
from tensorflow.keras import layers

early_stop = keras.callbacks.EarlyStopping(monitor='val_loss', patience=10)

def norm(x,train_stats):
	return (x - train_stats['mean']) / train_stats['std']


def build_model(train_dataset):
  model = keras.Sequential([
    layers.Dense(64, activation=tf.nn.relu, input_shape=[len(train_dataset.keys())]),
    layers.Dense(64, activation=tf.nn.relu),
    layers.Dense(1)
  ])

  optimizer = tf.keras.optimizers.RMSprop(0.001)

  model.compile(loss='mse',
                optimizer=optimizer,
                metrics=['mae', 'mse'])
  return model

class PrintDot(keras.callbacks.Callback):
	def on_epoch_end(self,epoch,logs):
		if epoch % 100 == 0 : print('')
		print('.',end='') 
