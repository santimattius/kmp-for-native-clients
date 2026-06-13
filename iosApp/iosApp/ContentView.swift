import SwiftUI
import Shared

struct ContentView: View {
    
    let logger = Sdk.shared.getLogger()
    
    var body: some View {
        NavigationView{
            VStack(alignment:.center,spacing: 8.0) {
                VStack(spacing: 16) {
                    Image(systemName: "swift")
                        .font(.system(size: 200))
                        .foregroundColor(.accentColor)
                    Text("SwiftUI: \(Greeting().greet())")
                }
                .transition(.move(edge: .top).combined(with: .opacity))
                Button("Basic Logger using Sdk") {
                    Sdk.shared.logger.logException(exception: NSError(domain: "test", code: 1, userInfo: nil))
                    
                }
                Button("Logger using Koin") {
                    logger.logException(exception: NSError(domain: "test", code: 1, userInfo: nil))
                    
                }
                Button("Hello Kvs") {
                    Task {
                        try? await Sdk.shared.writeKvs(key: "key", value: "Hello KVS")
                    }
                }
                NavigationLink(destination: CoroutineLimitationsView()) {
                    Text("Coroutine Limitations")
                }
            }.frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
            .padding()
            .navigationTitle("Examples")

        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
