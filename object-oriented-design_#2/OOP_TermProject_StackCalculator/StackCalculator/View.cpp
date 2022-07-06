#include <string>
#include <iostream>
#include "View.hpp"


using namespace std;



View::View()
{
	
}

void View::outputLine(const std::string& message)
{
	std::cout << message << std::endl;
}

void View::output(const std::string& message)
{
	std::cout << message ;
}

void View::outputDouble(const std::string& message, const double& result)
{
	std::cout << message << result << std::endl;
}

std::string View::input()
{	
	std::string input = " ";
	
	std::cin >> input ;
	
	return input;
}