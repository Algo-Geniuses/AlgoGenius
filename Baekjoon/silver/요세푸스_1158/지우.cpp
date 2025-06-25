#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N; int k;
    cin >> N;
    cin >> k;

    vector<int> v(N,0);

    for(int i=0; i<N; i++) {
        v[i] = i+1;
    }

    cout << "<";
    
    int curr = k-1;
    while(!v.empty()) {
        curr = (curr) % v.size(); // 현재 인덱스 (+보정)
        cout << v[curr];
        v.erase(v.begin() + curr);

        if(!v.empty()) {
            cout << ", ";
        }
        
        curr = (curr+k-1);
    }
    cout << ">";
}