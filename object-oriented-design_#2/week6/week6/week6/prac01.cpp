class Animal {
public:
	//...
protected:
	int age;
};

class Cat : public Animal {/*.....*/ };
class Dog : public Animal {/*....*/ };

class DogCat : public Cat, public Dog {
public:
	void setAge() {
		age = 10;
		Cat::age = 10;
	}
};
int main() {
	DogCat* dat = new DogCat();
	Animal* animal ;
	animal = dat;
	animal = static_cast <Cat*>(dat);
	animal = (Cat*)dat;
}
//class cat 과 class dog 는 class animal 를 상속받는다.
//이를 dogcat class 가 cat 과 dog 를 다중상속받는다.
//cat과 dog 는 animal 를 동시에 상속 받기 때문에
//dogcat 에서 age 를 선언할때 이 변수가 어디에 있는 변수인지
//파악할 필요가 있다.

//dat가 오류나는 이유는
//catdog 는 animal 객체를 상속받는 cat , dog class 가 존재하는데
//이중 cat 을 받는지 dog를 받는지 모호하기 때문에 에러가 발생한다.

