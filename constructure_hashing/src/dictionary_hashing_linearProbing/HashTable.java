package dictionary_hashing_linearProbing;

public class HashTable {
	private String[] words;
	private int size;
	
	public HashTable() {
		size = 101;
		words = new String[size];
	}
	
	public void add(String sentence) {
		sentence = sentence.replace('.', ' ');
		sentence = sentence.replace(',', ' ');
		String[] wordArray = sentence.split("\\s+");
		for (int i = 0; i < wordArray.length; i++) {
			this.addWord(wordArray[i]);
		}
	}
	
	private boolean addWord(String word) {
		word = word.toLowerCase();
		if (search(word)) {
			System.out.println(word + " repeated!");
			return false;
		}
		int index = this.getHashCode(word);
		if (words[index] == null) {
			words[index] = word;
			return true;
		}
		else {
			int newIndex = index;
			if (newIndex == words.length - 1)
				newIndex = 0;
			else
				newIndex++;
			while(words[newIndex] != null) {
				if (newIndex == index - 1) {
					System.out.println("Dictionary is full!");
					return false;
				}
				else if (newIndex == words.length - 1)
					newIndex = 0;
				else
					newIndex++;
			}
			words[newIndex] = word;
			return true;
		}
	}
	
	private int getHashCode(String key) {
		if (key == null || key.equals(""))
			return -1;
		key = key.toLowerCase();
		int k = 0, p = 1;
		char[] keyArray = key.toCharArray();
		for (int i = 0; i < keyArray.length; i++) {
			k += keyArray[i] * p;
			p *= 100;
		}
		return (k % size);
	}
	
	public boolean search(String key) {
		key = key.toLowerCase();
		int index = getHashCode(key), currentIndex = index;
		while (words[currentIndex] != null && !words[currentIndex].equals(key)) {
			currentIndex = (currentIndex + 1) % size;
			if (currentIndex == index)
				return false;
		}
		if (words[currentIndex] == null)
			return false;
		return true;
	}

}
