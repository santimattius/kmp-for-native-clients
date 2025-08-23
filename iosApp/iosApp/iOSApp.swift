import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init(){
        KoinContainer.shared.start()
        //Sdk.shared.registerLogger(logger: IOSLogger())
        Sdk.shared.registerLogger(logger: SwiftLogger())
        //Sdk.shared.registerDataStoreFactory(dataStoreFactory: DataStoreFactory())
        
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

class SwiftLogger: Logger {
    func logException(exception: any Error) {
        print("Hello swift logger \(exception)")
    }
    
}
