//Heizalee C. Ibiaz    BSCpE 3

// REFERENCES:
//gsamaras.Stack Overflow. (2014, May 14). C++ doubly linked list search and remove.URL https://stackoverflow.com/questions/23662984/c-doubly-linked-list-search-and-remove
//Codefarm.Codefarm. (2019, January 22). Insertion into doubly linked list : Algorithm and implementation in java || #GLlinkedlist. Youtube URL https://web.facebook.com/messenger_media/?attachment_id=3702905503273618&message_id=mid.%24cAAAABx8CfPOQsJXs5WKf1CrLxERY&thread_id=100007203068249
//ForMyScholars. ForMyScholars. (2021, August 27). Doubly Linked List - Deletion of a Node ( from Beginning ,End, Given Location) with Java Code #16. Youtube URL https://www.youtube.com/watch?v=gkDQNDh3q_0&t=172s
//Manish Sharma. JavadevJournal. (N.D). Doubly linked list in Java. URL https://www.javadevjournal.com/data-structure/doubly-linked-list-in-java/?fbclid=IwAR0Ze98QqPjGrwxcpIdIgGvoHWqdr2UvhI7kqcj1o7Lq8bX_ZgAIUY3Zy3s

package midtermsdll;

// declare variables
class Songplay {
    String title;
    Songplay next;
    Songplay prev;

    // construct new nodes using title as the data and return a pointer 
    public Songplay(String title) {
        this.title = title;
        this.next = null;
        this.prev = null;
    }
}

class Playlist {
	Songplay head;
	Songplay tail;
    Songplay current;

    public Playlist() {
        head = null;
        tail = null;
        current = null;
    }
    
    // Default behavior: Adding song at the end
    void addSong(String title) {
        addSongAtEnd(title); 
    }

    // insert a new song at the beginning of the playlist
    public void addSongAtBeginning(String title) { // add song at beginning method
        Songplay newSong = new Songplay(title); // declared a newNode
        if (head == null) {
            head = newSong;
            tail = newSong;
            current = newSong;
        } else {
        	newSong.next = head; // currently. newsong.next is the head
            head.prev = newSong;  // head.prev will be the new head entered by the user; para lang malocate
            head = newSong; // finally, new song will be the head; needs to decalre the newsong as the new head 
        }
    }

    // insert a new song at a specified position of the playlist
    public void addSongAtPosition(String title, int position) {
        Songplay newSong = new Songplay(title);

        
        if (position <= 0) { // if position is less than or equal to 0, add the new song at the beginning
            addSongAtBeginning(title);
        } else {
            if (head == null) {
                head = newSong;
                tail = newSong;
                current = newSong;
            } else {
                Songplay temp = head;
                int count = 0;

                while (temp != null && count < position - 1) { // iterates the whole playlist to look for the correct position
                    temp = temp.next; // then insert the song
                    count++; // means increment 
                }

                if (temp == null) { // if temp is equals to null, add the new song at the end
                    addSongAtEnd(title);
                } else {
                	newSong.next = temp.next; // declared as temporary first bec it will move din
                	newSong.prev = temp; 
                    if (temp.next != null) {
                        temp.next.prev = newSong; //will find the specific position to insert the new song
                    } else {
                        tail = newSong;
                    }
                    temp.next = newSong;
                }
            }
        }
    }

    // insert a new song at the end of the playlist
    public void addSongAtEnd(String title) { // traverse till the end and find the last song
        Songplay newSong = new Songplay(title);
        if (head == null) {
            head = newSong;
            tail = newSong;
            current = newSong;
        } else {
            tail.next = newSong; // tail.next will be the new entered song by user
            newSong.prev = tail; // the previous newsong is currently the tail here
            tail = newSong; // now the new song entered by the user will be the new tail 
        }
    }
    
    // delete current song 
    public void removeCurrentSong() { //reference: https://stackoverflow.com/questions/23662984/c-doubly-linked-list-search-and-remove
        
    	if (current != null) { // if current is not equal to null 
            if (current.prev != null) { // if the previous of current is not equal to null
                current.prev.next = current.next; // remove the previous of current
            } else {
                head = current.next; // magiging head na kasi deleted na yung current previous
            }

            if (current.next != null) { // if current next is not equal to null
                current.next.prev = current.prev; // remove the next of current
            } else {
                tail = current.prev; // magiging tail na kasi deleted na yung current next
            }

            current = current.next;
        }
    }

    // to forward/next song
    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    // to backward/previous song
    public void prevSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    // after deletion of every songs in the playlist it will display this
    public String getCurrentSong() {
        return current != null ? current.title : "No Treasure Song added";
    }

    // search a song from the playlist
    public Songplay searchSong(String title) {
    Songplay temp = head;
    while (temp != null) {
        if (temp.title.equals(title)) {
            return temp;
        }
        temp = temp.next;
    }
    
    // No song found
    return null; 
    	}
	}
