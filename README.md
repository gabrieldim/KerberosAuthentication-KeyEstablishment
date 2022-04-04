# Authentication between users using KDC server
###  For each class and method I wrote JavaDocs accordingly.
- Before you start, please open the picture attached in this repository to understand better what is this repository all about.
------------
- The Main class is actually a class in which all the functionalities of the application are tested. There are no functions inside this class, just a reference to pre-existing classes and methods.

- Because I needed proper authentication for authentication, I created the classes LifetimeExpiredException, NonceIsDifferentException, TimestampAfterLifetimeException, and UsersIDNotValidException so that the application does not stop when one of the checks fails. Additionally, these 4 classes are included in a separate Exceptions package.

- The Utils class is a class that contains methods that might be needed later in some other classes. The purpose of this class is only to invoke methods from it so as not to
unnecessary writing of the same code is done.

- I also implemented classes that I used to forward entire objects from one class to another in the application. Their implementation is for better visibility of the code.

=> Gabriel Dimitrievski
