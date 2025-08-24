//
//  CoroutineLimitationsView.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 23/8/25.
//

import SwiftUI
import Shared
import KMPNativeCoroutinesAsync

struct NativeCoroutineView: View {
    @State var viewModel = NativeCoroutineViewModel()
    
    var body: some View {
        VStack{
            Text("Native Coroutine")
            Text("User info: \(viewModel.userInfo)")
            Button("Async/Await") {
                viewModel.swiftConcurrency()
            }
            Button("Cancellation") {
                viewModel.cancellation()
            }
            Button("Error Handling") {
                viewModel.errorHandling()
            }
            Button("Flows") {
                viewModel.flows()
            }
        }.frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
        .navigationTitle("Coroutine Limitations")
    }
}

@Observable
class NativeCoroutineViewModel{
    private let userRepository = KoinContainer.shared.getUserRepository()
    private let numberRepository = KoinContainer.shared.getNumberFlowRepository()
    
    var userInfo = "unknown"
        
    func swiftConcurrency(){
        Task {
            try? await asyncFunction(for: userRepository.nativeFetchUserData())
        }
    }
    
    func cancellation(){
        // En Swift, esto parece funcionar normalmente
        Task {
            do {
                let user = try await asyncFunction(for: userRepository.nativeFetchUserData())
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
                let _ = try await asyncFunction(for: userRepository.nativeRandomUserData())
                // Procesar usuario
            } catch {
                print("Error: \(error)")
                userInfo = "Error: \(error)"
            }
        }
    }
 
     
    func flows(){
        Task {
            do {
                let sequence = asyncSequence(for: numberRepository.getNativeNumbers())
                for try await number in sequence {
                    print("Got number: \(number)")
                }
            } catch {
                print("Failed with error: \(error)")
            }
        }
    }

    
}

#Preview {
    NativeCoroutineView()
}
