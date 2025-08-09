import SwiftUI
import Shared

struct ContentView: View {
    var body: some View {
        VStack {
            VStack(spacing: 16) {
                Image(systemName: "swift")
                    .font(.system(size: 200))
                    .foregroundColor(.accentColor)
                Text("SwiftUI: \(Greeting().greet())")
            }
            .transition(.move(edge: .top).combined(with: .opacity))
            Button("Click me!") {
                Sdk.shared.logger.logException(exception: NSError(domain: "test", code: 1, userInfo: nil))
                
            }
            Button("Hello Android Context") {
                /*Storage.shared.write(
                    context: PlatformContext(),
                    key: "key",
                    value: "Hello Android Context"
                )*/
                Task {
                    try? await Sdk.shared.getKvs().write(key: "key", value: "Hello KVS")
                }
                
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
