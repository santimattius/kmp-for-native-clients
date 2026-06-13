import SwiftUI
import Shared

@main
struct iOSApp: App {

    init(){
        Sdk.shared.doInit()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
