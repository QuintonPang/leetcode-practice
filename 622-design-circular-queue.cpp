class MyCircularQueue {
public:
    vector <int> v;
    int max;
    int front = -1;
    int rear = -1;
    int size = 0;
    MyCircularQueue(int k) {
        this->max = k;
        this->v.resize(k);
    }
    
    bool enQueue(int value) {
        if(this->isEmpty()) front = 0;
        if(this->size == this->max) return false;
        this-> size++;
        this->rear = (rear+1) % this->max;
        this->v[rear] = value;
        return true;
    }
    
    bool deQueue() {
        if(this->isEmpty()) return false;
        this-> size--;
        if(this->size == 0) {this->front = -1; this->rear = -1;}
        else this->front = (front+1) % this->max;
        return true;
    
    }
    
    int Front() {
        if(this->isEmpty()) return -1;
        return v[front];
    }
    
    int Rear() {
        if(this->isEmpty()) return -1;
        return v[rear];
    }
    
    bool isEmpty() {
        return this->size == 0;
    }
    
    bool isFull() {
        return this-> size == this->max;
    }
};