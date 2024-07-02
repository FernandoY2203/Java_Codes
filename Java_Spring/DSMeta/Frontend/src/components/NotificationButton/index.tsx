import "./styles.css"
import notificationIcon from "../../assets/img/Notification_Icon.svg"
import axios from "axios";
import { BASE_URL } from "../../utils/request";
import { toast } from "react-toastify";

type Props = {
    saleId: number;
}

function handleClick(id : number) {
    axios(`${BASE_URL}/sales/${id}/notification`).then(response => {
        toast.info("SMS Enviado com Sucesso!!")
    })
}

function NotificationButton({saleId} : Props) {
    return (
        <div className="dsmeta-red-button" onClick={() => handleClick(saleId)}>
            <img src={notificationIcon} alt="Notification Icon"/>
        </div>
    )
}

export default NotificationButton