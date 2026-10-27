class RandomizedSet {
public:

    unordered_map<int, int> m;
    vector<int> v;
    RandomizedSet() {
        
    }
    
    bool insert(int val) {
        if(m.count(val)) return false;
        m[val]  = v.size();
        v.push_back(val);

        return true;
    }
    
    bool remove(int val) {
        if(m.count(val)==0) return false;

        int last = v[v.size()-1];
        int index = m[val];
        swap(v[index],v[v.size()-1]);
        v.pop_back();
        m[last] =  index;
        m.erase(val);

    return true;
    }
    
    int getRandom() {
        int index = rand() % v.size();
        return v[index];
    }
};