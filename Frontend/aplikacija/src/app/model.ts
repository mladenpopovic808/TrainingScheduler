export interface UserDto{
    id:number
    email:string
    firstName:string
    lastName:string
    username:string
    password:string
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
    id:number
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
 
    id:number
    emailManager:string
    salaName:string
    firstName:string
    lastName:string
    usernameManager:string
    password:string

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
    numberOfPersonalTrainers:number;

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
    trainingType:TrainingType
    trainingName:string
    minimumAvailableSpots:number
    availableSpots:number
    maximumAvailableSpots:number
}
enum TrainingType{
    GROUP="GROUP",SOLO="SOLO"
}


export interface TrainingDto{
    name:string
    typeOfTraining:TrainingType
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
    trainingType:TrainingType
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
   

