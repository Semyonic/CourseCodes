CMPE 407 / COMP 404 : Machine Learning Assignment 01
In this assignment students are going to code confusion matrix generetor:

Input: Dictionary [keys: actual, items: predicted]
Output: Formatted confusion matrix on screen
What is Confusion Matrix

In the field of machine learning, a confusion matrix, also known as a contingency table or an error matrix is a specific table layout that allows visualization of the performance of an algorithm, typically a supervised learning one. Each column of the matrix represents the instances in a predicted class, while each row represents the instances in an actual class. The name stems from the fact that it makes it easy to see if the system is confusing two classes (i.e. commonly mislabeling one as another).

Example

Data (as Python Dictionary, keys are actual classes and list of items are predicted samples. There are 10 subjects for every class):

data = {
'Dog': ['Dog', 'Rabbit', 'Cat', 'Rabbit', 'Cat', 'Rabbit', 'Rabbit', 'Cat', 'Rabbit', 'Cat'], 
'Rabbit': ['Dog', 'Cat', 'Dog', 'Rabbit', 'Cat', 'Rabbit', 'Cat', 'Rabbit', 'Rabbit', 'Rabbit'], 
'Cat': ['Rabbit', 'Dog', 'Cat', 'Cat', 'Rabbit', 'Dog', 'Cat', 'Cat', 'Dog', 'Cat']}
Predicted Class
Cat	Dog	Rabbit
Actual Class	Cat	5	3	0
Dog	2	3	1
Rabbit	0	2	11
Bonus

Also calculate and print the accuracy.

HINT: (sum of main diagonal elements) / (sum of every element of matrix)
