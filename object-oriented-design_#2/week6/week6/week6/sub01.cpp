class Animal {
public:
	//...
protected:
	int age;
};
class Cat : virtual public Animal {/*.....*/ };
class Dog : virtual public Animal {/*....*/ };
class DogCat : public Cat, public Dog {
public:
	void setAge() {
		age = 10;
		Cat::age = 10;
	}
};
int main() {
	DogCat* dat = new DogCat();
	Animal* animal;
	animal = dat;
	animal = static_cast <Cat*>(dat);
	animal = (Cat*)dat;
}

/*
다중상속에서 다이아몬드 구조를 띄게 될 경우 데이터의 중복과 불필요한 생성자 호출을 막기위해 virtual inheritance(가상 상속)을 사용한다.
가상 상속시 vbptr이라는 offset을 가르키는 포인터가 생성되며, virtual로 상속된 클래스는 메모리 구조에서 제일 아래로 가게된다.
시작 offset은 0이 될수도 있고 - (음수)가 될 수도 있다.
이러한 다중상속으로 인한 가상 상속은 기존 데이터 크기보다 더 커질 수 있으며, 성능 저하를 야기할 수 있다.

 virtual 명령어를 통해 모호성을 무시 할수 있음을 알 수 있다.
*/
