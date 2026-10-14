class MyCalendar {
public:
     
    vector<pair<int, int>> bookings;
    MyCalendar() {
        
    }
    
    bool book(int startTime, int endTime) {
        for(auto& booking: bookings){
            if(booking.second > startTime && booking.first < endTime) return false;
        }
        bookings.push_back({startTime, endTime});
        return true;
    }
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(startTime,endTime);
 */