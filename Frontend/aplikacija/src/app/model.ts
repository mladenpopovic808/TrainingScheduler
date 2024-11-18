export interface UserDto{
    id:number
    email:string
    firstName:string
    lastName:string
    username:string
    dateOfBirth:string
    numberOfSessions:number

    
}
export interface UserCreateDto{
    email:string
    firstName:string
    lastName:string
    username:string
    password:string
    dateOfBirth:string
}
export interface UserChangeDto{
    email:string
    firstName:string
    lastName:string
    username:string
    password:string
}
export interface TokenResponseDto{
    token:string
}
export interface TokenRequestDto{
    email:string
    password:string
}
export interface SendVerificationLinkToUserDto{
    userId:number
    link:string
    email:string
    firstName:string
    lastName:string
}
export interface ManagerDto{
 
    emailManager:string
    salaName:string
    firstName:string
    lastName:string
    usernameManager:string
}
export interface ManagerCreateDto{
    
    emailManager:string
    salaName:string
    firstName:string
    lastName:string
    usernameManager:string
    password:string

}
export interface IncrementNumberOfSessionsDto{
    userId:number
}

export interface SalaDto{
    name:string
    about:string
    numberOfPersonalTrainers:string

}
export interface SendScheduledTreningConfirmationDto{

    name:string
    lastName:string
    email:string
    start:string
    end:string
    trainingName:string
    salaName:string
    price:number

}
export interface TerminDto{

    salaId:number
    start:string
    end:string
    trainingType:string
    trainingName:string
    minimumAvailableSpots:number
    availableSpots:number
    maximumAvailableSpots:number
}
export interface TrainingTypeDto{

    name:string
    typeOfTraining:string
    price:number
}

export interface UserTerminCreateDto{
    userId:number
    terminId:number
}
export interface UserTerminDto{
    userId:number;
}
export interface UserTerminResponseDto{
    id:number
    terminId:number
    userId:number
    salaName:string
    start:string
    end:string
    trainingName:string
    trainingType:string
}
export interface SendScheduledTreningConfirmationDto{
    name:string
    lastName:string
    email:string
    start:string
    end:string
    trainingName:string
    salaName:string
    price:number
    toString:number

}
   

