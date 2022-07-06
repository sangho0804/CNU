#ifndef LinkedListStack_hpp
#define LinkedListStack_hpp

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

class Node {
public:
    char* Data;
    Node* nextNode;
};

class LinkedListStack {
private:
    Node* head;
    Node* tail;
    int stackSize;
public:
    LinkedListStack();
    Node* CreateNode(char* newData);
    void DestroyStack();
    void DestroyNode(Node* current);
    void Push(Node* newNode);
    Node* Pop();
    Node* GetTop();
    bool isEmpty();
    int size();
};
#endif /* LinkedListStack_hpp */