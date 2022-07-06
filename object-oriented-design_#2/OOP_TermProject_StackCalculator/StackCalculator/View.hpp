#include <string>
#include <iostream>

//View class
class View
{
public:
	View();

public:

	void outputLine(const std::string& message);
	void output(const std::string& message);
	void outputDouble(const std::string& message , const double& result);
	std::string input();
};