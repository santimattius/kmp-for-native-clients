//
// Created by Santiago Mattiauda on 15/10/25.
//

import Foundation
import Shared

public extension ProfileService{

    public func fetchProfileAsResult(id: Int) -> Result<User, Error>{
        do{
            let user = try fetchProfile(id: Int64(id))
            return .success(user)
        }catch {
            return .failure(error)
        }
    }
}