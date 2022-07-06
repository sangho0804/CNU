#include <iostream>

class MediaPlayer {
public:
	virtual void play(std::string audioType, std::string fileName) = 0;
};

class AdvancedMediaPlayer {
public:
	virtual void playVlc(std::string fileName) = 0;
	virtual void playMp4(std::string fileName) = 0;
};

class VlcPlayer : public AdvancedMediaPlayer {
public:
	void playVlc(std::string fileName) {
		std::cout << "Playing vlc file. Name : " + fileName << std::endl;
	}

	void playMp4(std::string fileName) {
		//do nothing
	}
};

class Mp4Player : public AdvancedMediaPlayer {
public:
	void playVlc(std::string fileName) {
		//do nothing
	}

	void playMp4(std::string fileName) {
		std::cout << "Playing mp4 file. Name : " + fileName << std::endl;
	}
};

class MediaAdapter : MediaPlayer {
public:
	// AdvancedMediaPlayer object ����, C++������ object��� object �����͸� �����ϰ� NULL�� �ʱ�ȭ �ؾ���.
	AdvancedMediaPlayer* advanceMusicPlayer = NULL;

	MediaAdapter(std::string audioType) {
		if (!audioType.compare("vlc")) {
			// advancedMusicPlayer ��ü�� VlcPlayer object�Ҵ�
			advanceMusicPlayer = new VlcPlayer();
		}
		else if (!audioType.compare("mp4")) {
			// advancedMusicPlayer ��ü�� Mp4Player object�Ҵ�
			advanceMusicPlayer = new Mp4Player();

		}
	}

	void play(std::string audioType, std::string fileName) {
		if (!audioType.compare("vlc")) {
			// ���õ� audioType�� ���� advancedMusicPlayer�� �Ҵ�� class�� play{audioType} �Լ� ȣ��
			advanceMusicPlayer->playVlc(audioType);
		}
		else if (!audioType.compare("mp4")) {
			// ���õ� audioType�� ���� advancedMusicPlayer�� �Ҵ�� class�� play{audioType} �Լ� ȣ��
			advanceMusicPlayer->playMp4(audioType);
		}
	}
};

class AudioPlayer : MediaPlayer {
public:
	// MediaAdapter object ����, C++������ �Ʒ��� new �����ڸ� ����ϱ� ���� object��� object �����͸� �����ؾ���.
	MediaAdapter* mediaAdapter;
	void play(std::string audioType, std::string fileName) {
		if (!audioType.compare("mp3")) {
			std::cout << "Playing mp3 file. Name : " + fileName << std::endl;
		}
		else if (!audioType.compare("vlc") || !audioType.compare("mp4")) {
			// MediaAdapter Class�� object�� mediaAdapter ����
			// mediaAdapter�� play ȣ��, mediaAdapter�� �������̹Ƿ� ȭ��ǥ(->) ������ Ȱ��
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter->play(audioType, fileName);
		}
		else
			std::cout << "Invalid media. : " + audioType + " format not supported" << std::endl;
	}
};

int main() {
	AudioPlayer* audiaPlayer = new AudioPlayer();

	audiaPlayer->play("mp3", "beyond the horizon.mp3");
	audiaPlayer->play("mp4", "alone.mp4");
	audiaPlayer->play("vlc", "far far away.vlc");
	audiaPlayer->play("avi", "mind me.avi");

	return 0;
}
