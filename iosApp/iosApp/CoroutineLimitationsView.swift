//
//  CoroutineLimitationsView.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 23/8/25.
//

import SwiftUI
import Shared

struct CoroutineLimitationsView: View {
    @State var viewModel = CoroutineLimitationsViewModel()
    
    var body: some View {
        VStack{
            Text("Coroutine Limitations")
            Text("User info: \(viewModel.userInfo)")
            Button("CompletionHandler") {
                viewModel.completionHandler()
            }
            Button("Async/Await") {
                viewModel.swiftConcurrency()
            }
            Button("Cancellation") {
                viewModel.cancellation()
            }
            Button("Error Handling") {
                viewModel.errorHandling()
            }
            Button("Thread") {
                viewModel.threads()
            }
            Button("Flows") {
                viewModel.cancelFlows()
            }
        }.frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
        .navigationTitle("Coroutine Limitations")
    }
}

@Observable
class CoroutineLimitationsViewModel{
    private let userRepository = KoinContainer.shared.getUserRepository()
    private let numberRepository = KoinContainer.shared.getNumberFlowRepository()
    private let platformRepository = KoinContainer.shared.getPlatformRepository()
    
    var userInfo = "unknown"
    
    func completionHandler() {
        //TODO: skie disable completionHandler
        /*self.userRepository.fetchUserData(completionHandler: { user, error in
            if let error = error {
                print("Error: \(error)")
                return
            }
            if let user = user {
                self.userInfo = user.firstName + " " + user.lastName
            }
            
        })*/
    }
    
    func swiftConcurrency(){
        Task {
            try? await userRepository.fetchUserData()
        }
    }
    
    func cancellation(){
        // En Swift, esto parece funcionar normalmente
        Task {
            do {
                let user = try await userRepository.fetchUserData()
                print(user)
            } catch {
                print("Error: \(error)")
                userInfo = "Error: \(error)"
            }
        }.cancel()
    }
    
    func errorHandling(){
        // En Swift, esto parece funcionar normalmente
        Task {
            do {
                let _ = try await userRepository.randomUserData()
                // Procesar usuario
            } catch {
                print("Error: \(error)")
                userInfo = "Error: \(error)"
            }
        }
    }
 
    //test this function with kotlin.native.binary.objcExportSuspendFunctionLaunchThreadRestriction=main
    func threads(){
        DispatchQueue.global().async {
            Task {
                // ⚠️ ESTO FALLARÍA sin SKIE
                let profile = try await self.userRepository.fetchUserData()
                DispatchQueue.main.async {
                    self.userInfo = profile.firstName + " " + profile.lastName
                }
            }
        }
    }
    
    func flows(){
        Task {
            for await it in numberRepository.getNumbers() {
                print("Got number: \(it)")
            }
        }
    }
    
    func cancelFlows(){
        let task = Task {
            for await it in numberRepository.getNumbers() {
                print("Got number: \(it)")
            }
        }
        task.cancel()

    }
    
    func overloaded(){
        Task {
            let repo = SwiftPlatformRepository()
            try? await repo.__getPlatform()
            try? await repo.getPlatform()
        }
    }
    
}

/*class AnyCollector : Kotlinx_coroutines_coreFlowCollector {
    func emit(value: Any?) async throws {
        print("Got number: \(value!)")
    }
}*/

class SwiftPlatformRepository: PlatformRepository {
    
    override func __getPlatform() async throws -> any Platform {
        return Platform_iosKt.getPlatform()
    }
}

#Preview {
    CoroutineLimitationsView()
}
