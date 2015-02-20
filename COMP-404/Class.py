# Comment
print "Okay"
# YaCmnt

print "Test"

print 25 + 30 / 6
print 100 - 25 * 3 % 4
print 3 + 2 + 1 - 5 + 4 % 2 - 1 / 4 + 6
print 3 + 2 < 5 - 7

print ""

cars = 100
space_in_a_car = 4.0
drivers = 30
passangers = 90
cars_not_driven = cars - drivers
cars_driven = drivers
carpool_capacity = cars_driven * space_in_a_car
average_passangers_per_car = passangers / cars_driven

print "Cars :", cars
print "Drivers :", drivers
print "Non-driven :", cars_not_driven
print "Capacity", carpool_capacity
print "Passangers", passangers

tabby_cat = "\tI'm tabbed in."
persian_cat = "I'm split\non a line."
backslash_cat = "I'm \\ a \\ cat."

fat_cat = """
I'll do a list:
\t* Cat food
\t* Fishies
\t* Catnip\n\t* Grass
"""

print tabby_cat
print persian_cat
print backslash_cat
print fat_cat


print "How old are you?",
age = raw_input()
print "How tall are you?",
height = raw_input()
print "How much do you weigh?",
weight = raw_input()

print "So, you're %r old, %r tall and %r heavy." % (
    age, height, weight)
