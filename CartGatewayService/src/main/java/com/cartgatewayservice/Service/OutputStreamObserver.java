package com.cartgatewayservice.Service;



import com.cartgatewayservice.Model.ClientEntity;
import com.grpcserver.GuestClientServer.ClientGuestRequest;

import org.springframework.beans.factory.annotation.Autowired;

import io.grpc.stub.StreamObserver;

public class OutputStreamObserver implements StreamObserver<ClientGuestRequest> {

    @Autowired
    private ClientEntity clientEntity;

    @Override
    public void onNext(ClientGuestRequest value) {

        clientEntity.setClient_guest_id(value.getClientGuestId());
        clientEntity.setClient_guest_name(value.getClientGuestName());
        clientEntity.setClient_guest_email(value.getClientGuestEmail());

       
    }

    @Override
    public void onError(Throwable t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onCompleted() {
        // TODO Auto-generated method stub
        
    }

   
}
