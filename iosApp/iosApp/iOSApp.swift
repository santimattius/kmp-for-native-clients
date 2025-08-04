import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init(){
        Sdk.shared.registerLogger(logger: IOSLogger())
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
