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
���߻�ӿ��� ���̾Ƹ�� ������ ��� �� ��� �������� �ߺ��� ���ʿ��� ������ ȣ���� �������� virtual inheritance(���� ���)�� ����Ѵ�.
���� ��ӽ� vbptr�̶�� offset�� ����Ű�� �����Ͱ� �����Ǹ�, virtual�� ��ӵ� Ŭ������ �޸� �������� ���� �Ʒ��� ���Եȴ�.
���� offset�� 0�� �ɼ��� �ְ� - (����)�� �� ���� �ִ�.
�̷��� ���߻������ ���� ���� ����� ���� ������ ũ�⺸�� �� Ŀ�� �� ������, ���� ���ϸ� �߱��� �� �ִ�.

 virtual ��ɾ ���� ��ȣ���� ���� �Ҽ� ������ �� �� �ִ�.
*/
