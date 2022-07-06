#ifndef Controller_hpp
#define Controller_hpp

#include <stdio.h>

class Controller
{
public:
	std::string END_OF_CALCULATION = "!";

public:
	virtual void run();

}; 
#endif 