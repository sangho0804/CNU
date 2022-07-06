﻿#include "LinkedListStack.hpp"

LinkedListStack::LinkedListStack() {
    head = NULL;
    tail = NULL;
    stackSize = 0;
}

Node* LinkedListStack::CreateNode(char* newData) {
    Node* newNode = (Node*)malloc(sizeof(Node));

    newNode->Data = (char*)malloc(strlen(newData) + 1);
    strcpy(newNode->Data, newData);
    newNode->nextNode = NULL;

    return newNode;
}

void LinkedListStack::DestroyStack() {
    while (!isEmpty()) {
        Node* popNode = Pop();
        DestroyNode(popNode);
    }
    this->stackSize = 0;
}

void LinkedListStack::DestroyNode(Node* current) {
    free(current->Data);
    free(current);
}

void LinkedListStack::Push(Node* newNode) {
    if (head == NULL) {
        head = newNode;
        
    }
    else {
        tail->nextNode = newNode;
        
    }
    this->stackSize++;
    tail = newNode;
}

Node* LinkedListStack::Pop() {
    Node* popNode = tail;

    if (head == tail) {
        head = NULL;
        tail = NULL;
    }
    else {
        Node* current = head;
        while (current->nextNode != popNode) {
            current = current->nextNode;
        }
        tail = current;
        tail->nextNode = NULL;
        this->stackSize--;
    }

    return popNode;
}

Node* LinkedListStack::GetTop() {
    return tail;
}

bool LinkedListStack::isEmpty() {
    return (head == NULL && tail == NULL);
}

int LinkedListStack::size() {

    return this->stackSize;
}