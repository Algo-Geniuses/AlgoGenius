#include <iostream>
#include <stack>
#include <string>

using namespace std;

int 우선순위(char c) {
    if(c == '*' || c == '/') {
        return 2;
    } else if(c=='+' || c=='-') {
        return 1;
    } else { //괄호
        return 0;
    }
}

int main() {
    string s; cin >> s; 
    string ans = "";

    stack<char> st;

    for(int i=0; i<s.length(); i++) { 
        if(s[i] >= 'A' && s[i] <= 'Z') {
            ans += s[i];
        }
        else if(s[i] == ')') {
            while(!st.empty() && st.top() != '(') {
                ans += st.top(); st.pop();
            }
            st.pop(); // ( 도 빼줘야 함
        }
        else if(s[i] == '(') {
            st.push(s[i]);
        }
        else {
            if(st.empty() || 우선순위(s[i]) > 우선순위(st.top())) { // 비었을 때도 고려!!!
                st.push(s[i]);
            } else {
                while(!st.empty() && 우선순위(st.top()) >= 우선순위(s[i])) {
                    if (st.top() != '(') ans += st.top();
                    st.pop();
                }
                st.push(s[i]);
            }
        }
    }

    while(!st.empty()) {
        ans += st.top(); st.pop();
    }

    cout << ans;

    
    return 0;
}