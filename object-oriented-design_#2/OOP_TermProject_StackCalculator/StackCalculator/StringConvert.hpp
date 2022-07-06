#ifndef StringConvert_hpp
#define StringConvert_hpp

#include <stdio.h>
#include <string>

using namespace std;

class StringConvert
{
public:
	const string actionStringConvert(const string  &inputText);
	char ex[4] = { '*' , '+' , '-' , '/' };
	bool ex_check(char text);
};

#endif