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
//class cat �� class dog �� class animal �� ��ӹ޴´�.
//�̸� dogcat class �� cat �� dog �� ���߻�ӹ޴´�.
//cat�� dog �� animal �� ���ÿ� ��� �ޱ� ������
//dogcat ���� age �� �����Ҷ� �� ������ ��� �ִ� ��������
//�ľ��� �ʿ䰡 �ִ�.

//dat�� �������� ������
//catdog �� animal ��ü�� ��ӹ޴� cat , dog class �� �����ϴµ�
//���� cat �� �޴��� dog�� �޴��� ��ȣ�ϱ� ������ ������ �߻��Ѵ�.

