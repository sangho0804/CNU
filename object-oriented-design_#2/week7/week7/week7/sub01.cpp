#include<iostream>

#define interface struct

interface Strategy {
public:
    virtual int doOperation(int num1, int num2) = 0;
};

class OperationAdd : public Strategy {

public:
    //override
    int doOperation(int num1, int num2) {
        return num1 + num2;
    }
};
class OperationSubstract : public  Strategy {

public:
    //override
    int doOperation(int num1, int num2) {
        return num1 - num2;
    }
};
class OperationMultiply : public Strategy {

public:
    //override
    int doOperation(int num1, int num2) {
        return num1 * num2;
    }
};
class Context {
private:
    Strategy* strategy;
public:
    Context(Strategy* strategy) {
        this->strategy = strategy;
    }
public:
    int executeStrategy(int num1, int num2) {
        return strategy->doOperation(num1, num2);
    }
};

int main() {
    Context* context = new Context(new OperationAdd());
    std::cout << "10 + 5 = " << context->executeStrategy(10, 5) << std::endl;
    context = new Context(new OperationSubstract());
    std::cout << "10 - 5 = " << context->executeStrategy(10, 5) << std::endl;
    context = new Context(new OperationMultiply());
    std::cout << "10 * 5 = " << context->executeStrategy(10, 5) << std::endl;

}
//test
