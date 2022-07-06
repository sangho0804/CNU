#include <iostream>

class GlobalLogger
{
	int log_value;
public:
	GlobalLogger(int v = 0)
	{
		log_value = v;
	}
	int get_log_data()
	{
		return log_value;
	}
	void set_log_data(int v)
	{
		log_value = v;
	}
};

// Default initialization
GlobalLogger* global_Logger_ptr = 0;

void Logger_User_A(void)
{
	// Initialization on first use
	if (!global_Logger_ptr)
		global_Logger_ptr = new GlobalLogger;
	global_Logger_ptr->set_log_data(1);
	std::cout << "Logger_User_A: log_data is " << global_Logger_ptr->get_log_data() << '\n';
}

void Logger_User_B(void)
{
	if (!global_Logger_ptr)
		global_Logger_ptr = new GlobalLogger;
	global_Logger_ptr->set_log_data(2);
	std::cout << "Logger_User_B: log_data is " << global_Logger_ptr->get_log_data() << '\n';
}

int main()
{
	if (!global_Logger_ptr)
		global_Logger_ptr = new GlobalLogger;
	std::cout << "main: log_data is " << global_Logger_ptr->get_log_data() << '\n';
	Logger_User_A();
	Logger_User_B();
}

//하나의 객체로 저장되는것이 아님
//함수를 실행하며 각각의 객체를 생성한다.
//때문에 메모리 낭비를 야기함
//그렇기에 로그파일에 각각의 A B 가 함께 저장되는 것이 아니기에
//로그를 기록한다는 의미가 없어진다.
