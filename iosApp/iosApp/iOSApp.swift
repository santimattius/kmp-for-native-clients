import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init(){
        Sdk.shared.registerLogger(logger: IOSLogger())
        Sdk.shared.registerDataStoreFactory(dataStoreFactory: DataStoreFactory())
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
