# Distributed Calculator Project


1. [Introduction](#introduction)
2. [User Requirements](#user-requirements)
   - [The difference between RMI and Sockets](#the-difference-between-rmi-and-sockets)
3. [Maquette](#maquette)
4. [Use case diagram](#use-case-diagram)
5. [Class diagram](#class-diagram)
6. [Sequence diagram](#sequence-diagram)
7. [Result](#result)
8. [Test and Usage](#test-and-usage)
9. [Conclusion](#conclusion)




## 1.Introduction
This document is a report for a mini-project, “Calculator”. The main aim
of this mini-project is to design and create a very simple calculator. RMI
has to be practiced and implemented in the project. RMI is a simple
method to create client-server programs with “Remote Procedure Call”
protocol. The client application that is running locally will invoke methods
on server.

This application can execute basic mathematical operations on positive
integers such as, addition, subtraction, multiplication and integer division.
It is written in Java programming language. Swing and Abstract Window
Toolkit is used for GUI.

## 2.User Requirements
- Give two positive integers
- Choose a mathematical operation
- Delete last chosen operation or integer
- Delete the result(clear)
- Works with RMI

### The difference between RMI and Sockets
There was a dilemma when decision had to be made between Sockets
and RMI. Research showed that RMI is good for business. It allows
one to read and write objects, and call methods on remote objects. It
is highly optimized as it is a mature technology, which has been
around for over 10 years. RMI allows the Java Application to
communicate with any other client. RMI can be used to create a
distributed object on which the client can call methods. It also allows
for stateless connections to the server.

Sockets deal with low-level workings of connections. With RMI one
can concentrate on the high-level requirements and not worry about
the underlying workings of connections. One of the things that was a
disadvantage for RMI was the slower performance compared to
Sockets, due to the fact that a proxy is needed for each RMI remote
object.

We learned that RMI is much easier to work with than Sockets,
because when working with RMI, one doesn’t need to design a
protocol between the client and server. Hence, it was decided to use
RMI for the project.



## 3. Maquette
## 4. Use case diagram
## 5. Class diagram
## 6. Sequence diagram
## 7. Result 
In the above class diagram, we can see that “Distributed Calculator using
RMI” is implemented using 5 classes and 1 interface. Those are located
in 3 different Folders with following names:
- Server: which has the implementation of “Server” and has access to
“Client” class, “Calculator” class, “Operation Handler” interface and
“Operation Handler Implementation” class.
- Client: which has the implementation of “Client” and has access to
“Calculator” class, “Operation Handler” interface
- Services: which has the implementation of “Calculator” class,
“Operation Handler” interface and “Operation Handler Implementation”
class.


“Server.java” file implements the typical behavior of the server side:
Defines port (1099) - in case user doesn’t provide a port through
command line, default port is used.
Creates an instance of OperationHandlerImplementation class and casts
it to OperationHandler interface, as Client knows only interface.
Exports “Skeleton” to the Java RMI, so that it can receive incoming
remote calls.

Locates the registry at the given port.

Binds the skeleton to the name “Calculator” in the registry

“Client.java” file implements the typical behavior of the client side:
Defines a port (1099).

Locates the registry.

Creates an instance of the class “Calculator” which results the
appearance of the calculator app’s window.

Creates a stub, which is also casted to OperationHandler and look for the
name "Calculator" which represents the remote object's skeleton in that
registry.

In while loop it checks whether everything is ready for calculation, and if
so, it invokes the remote method (calculate) on the stub.

“OperationHandler.java” file has the definition of the access interface to
the remote addressable object.

“OperationHandlerImplementation” file has the definition of the class
implementing the code that will actually perform the operations defined in
the interface

“Calculator.java” file has the whole implementation of Calculator using
swing.

## 8. Test and Usage



## 9. Conclusion
Throughout the procedure of the project development, RMI, AWT and
Swing have been profusely practiced. By practicing with client-server
connections and threads, a good experience on the matter was
acquired. With the project, our coding skills sharpened at Java
programming language. Considering the unprecedented situation, we
kept in contact through online means, hence improving our teamwork
skills and learned how to work remotely, getting good experience at
the respective future career. By working on the specifications, we
learned how to work with diagrams, such as use case diagram, class
diagram, sequence diagram.
