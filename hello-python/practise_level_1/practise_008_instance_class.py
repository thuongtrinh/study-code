class Person:
    name = "Person"

    def __init__(self, name=None):
        self.name = name

p = Person
p.name = "thuongtx"
print(p.name)

p = Person("Alice")
print("%s name is %s" % (Person.name, p.name))

nico = Person()
nico.name = "Nico"
print("%s name is %s" % (Person.name, nico.name))


