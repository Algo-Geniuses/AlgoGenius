#include <iostream>
#include <vector>

using namespace std;

int N; int Q;
vector<vector<pair<int, int>>> adj; // 연결된 것만 담아야겠다.

int recommend(vector<bool>& visited, int k, int num) { // 참조 복사 해야 함 (N돌면서 복사하니까)
    visited[num] = true;
    int cnt = 0;
    
    for(auto c: adj[num]) {
        int nxt = c.first;
        int w = c.second;

        if(!visited[nxt] && w >= k) {
            cnt ++;
            cnt += recommend(visited, k, nxt);
        }
    }

    return cnt;
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> Q;
    adj = vector<vector<pair<int, int>>>(N+1);

    for(int i=0; i<N-1; i++) {
        int a; int b; int w;
        cin >> a >> b >> w;
        adj[a].push_back({b,w});
        adj[b].push_back({a,w});
    }

    
    for(int i=0; i<Q; i++) {
        vector<bool> visited(N+1, false); // 1 2 3 4
        
        int k; int num;
        cin >> k >> num;
        
        cout << recommend(visited, k, num) << "\n";
    }
    
    return 0;
}