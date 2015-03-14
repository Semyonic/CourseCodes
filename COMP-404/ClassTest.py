data = {
'Dog': ['Dog', 'Rabbit', 'Cat', 'Rabbit', 'Cat', 'Rabbit', 'Rabbit', 'Cat', 'Rabbit', 'Cat'], 
'Rabbit': ['Dog', 'Cat', 'Dog', 'Rabbit', 'Cat', 'Rabbit', 'Cat', 'Rabbit', 'Rabbit', 'Rabbit'], 
'Cat': ['Rabbit', 'Dog', 'Cat', 'Cat', 'Rabbit', 'Dog', 'Cat', 'Cat', 'Dog', 'Cat']}

labels = {'Dog','Rabbit','Cat'}

data2= [[0 for i in range(3)] for j in range(3)]
print data2
for d1 in range(3):
	for d2 in range(3):
		data2[d1][d2]
print data2
