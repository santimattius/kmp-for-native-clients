//
//  Types.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 15/10/25.
//

import Shared

func selead() {
    Task{
        let locationRepo = SwiftLocationRepository()
        let status = try await locationRepo.getLastLocation()
        switch(onEnum(of: status)){
        case .error(let message):
            print(message)
        case .success(let location):
            print(location)
        }
    }
}

class SwiftLocationRepository: LocationRepository {
 
    
    func __getCurrentLocation() async throws -> Any? {
        <#code#>
    }
    
    func __updateLocation(location: Location) async throws -> Any? {
        <#code#>
    }
    
    func __getLastLocation() async throws -> Status {
        <#code#>
    }
    
}

func exceptions(){
    do {
        let service = ProfileServiceImpl()
        let user = try service.fetchProfile(id: 42)
        print(user)
    } catch let error as NetworkError {
        print(error)
    } catch {
        // fallback
    }
}

func exceptionsAsResult(){
    let service = ProfileServiceImpl()
    let result = service.fetchProfileAsResult(id: 42)
    switch result {
    case .success(let user):
        print(user)
    case .failure(let error):
        print(error)
    }
}



func generics() {
    Task{
        let repository = Repository<User>()
        try await skie(repository).set(value: User(
            firstName: "Santiago", lastName: "Mattiauda")
        )
    }
}
