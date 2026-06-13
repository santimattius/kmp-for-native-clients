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
    private let userRepository = Sdk.shared.getUserRepository()
    private let platformRepository = Sdk.shared.getPlatformRepository()

    var userInfo = "unknown"

    func completionHandler() {
        // Not supported with Swift Export (no SKIE completion handler bridge)
    }

    func swiftConcurrency(){
        Task {
            try? await userRepository.fetchUserData()
        }
    }

    func cancellation(){
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
        Task {
            do {
                let _ = try await userRepository.randomUserData()
            } catch {
                print("Error: \(error)")
                userInfo = "Error: \(error)"
            }
        }
    }

    func threads(){
        Task {
            // Swift Export: no thread restriction — suspend funs dispatch on Kotlin's scheduler
            let profile = try await self.userRepository.fetchUserData()
            await MainActor.run {
                self.userInfo = profile.firstName + " " + profile.lastName
            }
        }
    }

    func cancelFlows(){
        let task = Task {
            let flow = Sdk.shared.getNumberFlowRepository().getNumbers()
            for try await number in flow.asAsyncSequence() {
                print("Got number: \(number)")
            }
        }
        task.cancel()
    }
}


#Preview {
    CoroutineLimitationsView()
}
